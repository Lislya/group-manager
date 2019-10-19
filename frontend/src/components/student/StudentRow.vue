<template>
    <v-card class="my-1">
        <v-card-title>
            {{student.firstName}}
            {{student.secondName}}
            {{student.middleName}}
        </v-card-title>
        <v-card-text>
            <v-simple-table>
                <template v-slot:default>
                    <tbody>
                    <tr>
                        <td>ID</td>
                        <td>{{ student.id }}</td>
                    </tr>
                    <tr>
                        <td>Курс</td>
                        <td>{{ student.course }}</td>
                    </tr>
                    <tr>
                        <td>Факультет</td>
                        <td>{{ student.faculty }}</td>
                    </tr>
                    <tr>
                        <td>Группа</td>
                        <td>{{ student.team }}</td>
                    </tr>
                    </tbody>
                </template>
            </v-simple-table>
        </v-card-text>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn small text rounded @click="edit">Edit</v-btn>
            <v-btn small text rounded @click="del">X</v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
export default {
  name: 'StudentRow',
  props: ['student'],
  methods: {
    edit () {
      this.$emit('editStudent', this.student)
    },
    del () {
      this.$emit('deleteStudent', this.student)
    }
  }
}
</script>

<style scoped>

</style>
