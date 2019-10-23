<template>
    <v-card
        flat
        tile
    >
        <v-list v-if="students.length !== 0 || labworks.length !== 0">
            <v-list-group prepend-icon="mdi-account-circle">
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
                    </v-list-item-title>
                </v-list-item>
            </v-list-group>

            <v-list-group prepend-icon="mdi-flask-outline">
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
                    <v-list-item-title v-text="labwork.name"></v-list-item-title>
                </v-list-item>
            </v-list-group>
        </v-list>
        <v-list v-else>
            <v-list-group prepend-icon="mdi-account-circle">
                <template v-slot:activator>
                    <v-list-item-content>
                        <v-list-item-title>Участники</v-list-item-title>
                    </v-list-item-content>
                </template>
            </v-list-group>
            <v-list-group prepend-icon="mdi-flask-outline">
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
  }
}
</script>

<style scoped>

</style>
