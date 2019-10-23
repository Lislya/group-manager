<template>
    <v-layout>
        <v-text-field @keyup.enter="save" label="Имя" placeholder="Введите имя" v-model="firstName"></v-text-field>
        <v-text-field @keyup.enter="save" label="Фамилия" placeholder="Введите фамилию" v-model="secondName"></v-text-field>
        <v-text-field @keyup.enter="save" label="Отчество" placeholder="Введите отчество" v-model="middleName"></v-text-field>
        <v-text-field @keyup.enter="save" label="Курс" placeholder="Введите курс" v-model="course"></v-text-field>
        <v-text-field @keyup.enter="save" label="Факультет" placeholder="Введите факультет" v-model="faculty"></v-text-field>
        <v-text-field @keyup.enter="save" label="Группа" placeholder="Введите группу" v-model="studyGroup"></v-text-field>
        <v-btn rounded text @click="save" v-on:keypress.enter="save">
            <v-icon x-large>mdi-content-save-outline</v-icon>
        </v-btn>
    </v-layout>
</template>

<script>
export default {
  name: 'StudentForm',
  props: ['students', 'currentStudent'],
  data () {
    return {
      id: '',
      firstName: '',
      secondName: '',
      middleName: '',
      course: '',
      faculty: '',
      studyGroup: ''
    }
  },
  watch: {
    currentStudent (currStudent) {
      this.id = currStudent.id
      this.firstName = currStudent.firstName
      this.secondName = currStudent.secondName
      this.middleName = currStudent.middleName
      this.course = currStudent.course
      this.faculty = currStudent.faculty
      this.studyGroup = currStudent.studyGroup
    }
  },
  methods: {
    save () {
      let student =
        {
          firstName: this.firstName,
          secondName: this.secondName,
          middleName: this.middleName,
          course: this.course,
          faculty: this.faculty,
          studyGroup: this.studyGroup
        }

      if (this.id) {
        this.$resource('api/user/student/{id}')
          .update({ id: this.currentStudent.id }, student)
          .then(response => response.json()
            .then(data => {
              const index = this.students.findIndex(item => item.id === data.id)
              this.students.splice(index, 1, data)
            }))
      } else {
        this.$http.post('api/user/student', student)
          .then(response => response.json()
            .then(data => {
              this.students.push(data)
            }))
      }
      this.id = ''
      this.firstName = ''
      this.secondName = ''
      this.middleName = ''
      this.course = ''
      this.faculty = ''
      this.studyGroup = ''
    }
  }
}
</script>

<style scoped>

</style>
