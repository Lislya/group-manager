<template>
    <v-tabs
        background-color="deep-grey"
        class="elevation-2"
        dark
        grow
        vertical
        v-model="tab"
    >
        <v-tabs-slider></v-tabs-slider>

        <v-tab
            v-for="tab in tabs"
            :key="tab.id"
            :href="`#tab-${tab.id}`"
            @click="fetchTeam(tab.id)"
        >
            Бригада {{ tab.id }}
        </v-tab>
        <v-btn :ripple="false" @click="addTeam">
            <v-icon>mdi-plus</v-icon>
        </v-btn>

        <v-tab-item
            v-for="tab in tabs"
            :key="tab.id"
            :value="'tab-' + tab.id"
        >
            <team-tab-content
                :students="students"
                :labworks="labworks"
                @removeStudentFromTeam="removeStudentFromTeam"
                @removeLabworkFromTeam="removeLabworkFromTeam"
            >
            </team-tab-content>
        </v-tab-item>
    </v-tabs>
</template>

<script>
import TeamTabContent from '@/components/team/TeamTabContent'

export default {
  name: 'TeamTabs',
  components: {
    TeamTabContent
  },
  data () {
    return {
      tab: null,
      tabs: [],
      students: [
        { id: 1, firstName: 'Daniel', secondName: 'Kim', middleName: '' },
        { id: 2, firstName: 'Anna', secondName: 'Goryacheva', middleName: '' },
        { id: 3, firstName: 'Polina', secondName: 'Golitsina', middleName: '' }
      ],
      labworks: [
        { id: 1, name: 'Лабораторная работа 1' },
        { id: 2, name: 'Лабораторная работа 2' },
        { id: 3, name: 'Лабораторная работа 3' }
      ]
    }
  },
  async created () {
    const response = await this.$http.get('api/team')
    const data = await response.json()
    data.forEach(tab => this.tabs.push(tab))
  },
  methods: {
    async addTeam () {
      const response = await this.$http.post('api/team')
      const data = await response.json()
      this.tabs.push(data)
    },
    async fetchTeam (teamId) {
      const response = await this.$resource('api/team/{id}').get({ id: teamId })
      const data = await response.json()
      this.students = data.students
      this.labworks = data.labworks
    },
    removeStudentFromTeam (student) {
      this.students.splice(this.students.indexOf(student), 1)
    },
    removeLabworkFromTeam (labwork) {
      this.labworks.splice(this.labworks.indexOf(labwork), 1)
    }
  }
}
</script>

<style scoped>

</style>
