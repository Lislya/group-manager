<template>
    <v-layout fill-height column>
        <student-row v-for="student in sortedStudents"
            v-bind:key="student.id"
            :student="student"
            @editStudent="editStudent"
            @deleteStudent="deleteStudent">
        </student-row>
    </v-layout>
</template>

<script>
import StudentRow from './StudentRow'
export default {
  name: 'StudentTable',
  components: { StudentRow },
  props: ['students'],
  computed: {
    sortedStudents () {
      return this.students.sort((a, b) => -(a.id - b.id))
    }
  },
  methods: {
    editStudent (student) {
      this.$emit('editStudentAttrs', student)
    },
    deleteStudent (student) {
      this.$resource('api/user/student/{id}')
        .delete({ id: student.id })
        .then(response => {
          if (response.ok) {
            this.students.splice(this.students.indexOf(student), 1)
          }
        })
    }
  }
}
</script>

<style scoped>

</style>
