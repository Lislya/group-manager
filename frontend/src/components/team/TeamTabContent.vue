<template>
    <v-card
        flat
        tile
    >
        <v-list>
            <v-list-group v-if="students.length !== 0" prepend-icon="mdi-account-circle">
                <template v-slot:activator>
                    <v-list-item-content>
                        <v-list-item-title>Участники</v-list-item-title>
                    </v-list-item-content>
                </template>
                <v-list-item
                    v-for="student in students"
                    :key="student.id"
                    link
                >
                    <v-list-item-title>
                        {{ student.firstName }} {{ student.secondName }} {{ student.middleName }}
                        <v-btn icon color="red" @click="removeStudent(student)">
                            <v-icon>mdi-delete-outline</v-icon>
                        </v-btn>
                    </v-list-item-title>
                </v-list-item>
            </v-list-group>
            <v-list-group v-else prepend-icon="mdi-account-circle">
                <template v-slot:activator>
                    <v-list-item-content>
                        <v-list-item-title>Участники</v-list-item-title>
                    </v-list-item-content>
                </template>
            </v-list-group>

            <v-list-group v-if="labworks.length !== 0" prepend-icon="mdi-flask-outline">
                <template v-slot:activator>
                    <v-list-item-content>
                        <v-list-item-title>Лабораторные работы</v-list-item-title>
                    </v-list-item-content>
                </template>

                <v-list-item
                    v-for="labwork in labworks"
                    :key="labwork.id"
                    link
                >
                    <v-list-item-title>
                        {{ labwork.name }}
                        <v-btn icon color="red" @click="removeLabwork(labwork)">
                            <v-icon>mdi-delete-outline</v-icon>
                        </v-btn>
                    </v-list-item-title>
                </v-list-item>
            </v-list-group>
            <v-list-group v-else prepend-icon="mdi-flask-outline">
                <template v-slot:activator>
                    <v-list-item-content>
                        <v-list-item-title>Лабораторные работы</v-list-item-title>
                    </v-list-item-content>
                </template>
            </v-list-group>
        </v-list>
    </v-card>
</template>

<script>
export default {
  name: 'TeamTabContent',
  props: ['students', 'labworks'],
  data () {
    return {

    }
  },
  methods: {
    removeStudent (student) {
      this.$emit('removeStudentFromTeam', student)
    },
    removeLabwork (labwork) {
      this.$emit('removeLabworkFromTeam', labwork)
    }
  }
}
</script>

<style scoped>

</style>
