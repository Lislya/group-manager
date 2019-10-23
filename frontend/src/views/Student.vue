<template>
    <v-layout fullheight column>
        <h1>Студенты</h1>
        <v-layout column>
            <student-form :students="students" :currentStudent="currentStudent" :teams="teams"/>
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
      currentStudent: null,
      teams: []
    }
  },
  async created () {
    // get students
    let response = await this.$http.get('/api/user/student')
    let data = await response.json()
    data.forEach(student => this.students.push(student))

    // get teams
    response = await this.$http.get('api/team')
    data = await response.json()
    data.forEach(team => this.teams.push(team))
  },
  methods: {
    editStudentAttrs (student) {
      this.currentStudent = student
    }
  }
}
</script>

<style scoped>
</style>
