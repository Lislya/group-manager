<template>
    <v-layout fullheight column>
        <h1>Студенты</h1>
        <v-layout column>
            <student-form :students="students" :currentStudent="currentStudent"/>
            <student-table :students="students" @editStudentAttrs="editStudentAttrs"></student-table>
        </v-layout>
    </v-layout>
</template>

<script>
import StudentTable from '@/components/student/StudentTable'
import StudentForm from '@/components/student/StudentForm'

export default {
  name: 'student',
  components: {
    StudentTable,
    StudentForm
  },
  data () {
    return {
      students: [],
      currentStudent: null
    }
  },
  created () {
    this.$http.get('/api/user/student')
      .then(result => result.json()
        .then(data => data.forEach(student => this.students.push(student))))
  },
  methods: {
    editStudentAttrs (student) {
      this.currentStudent = student
    }
  }
}
</script>

<style scoped>
    .student-form {
        width: 500px;
    }
</style>
