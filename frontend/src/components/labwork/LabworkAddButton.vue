<template>
    <v-row justify="start" class="mx-3">
        <v-dialog v-model="dialog" persistent max-width="600px">
            <template v-slot:activator="{ on }">
                <h1>Лабораторные работы</h1>
                <v-btn small class="mx-3" fab dark color="primary" v-on="on">
                    <v-icon small dark>mdi-plus</v-icon>
                </v-btn>
            </template>
            <v-card>
                <v-card-title>
                    <span class="headline">Добавить работу</span>
                </v-card-title>
                <v-card-text>
                    <v-container>
                        <v-row>
                            <v-col cols="12" sm="2" md="2">
                                <v-text-field
                                    label="№"
                                    required
                                    v-model="number"
                                ></v-text-field>
                            </v-col>
                            <v-col cols="12" sm="2" md="10">
                                <v-text-field
                                    label="Название"
                                    hint="полное наименование л/р"
                                    v-model="name"
                                ></v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-textarea
                                    v-model="task"
                                    name="input-7-1"
                                    label="Задание"
                                    value="Лабораторная работа № ..."
                                ></v-textarea>
                            </v-col>
                        </v-row>
                    </v-container>
                    <small>*обязательные поля</small>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="close">Close</v-btn>
                    <v-btn color="blue darken-1" text @click="save">Save</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-row>
</template>

<script>
export default {
  name: 'LabworkAddButton',
  props: ['cards'],
  data: () => ({
    dialog: false,
    number: '',
    name: '',
    task: ''
  }),
  methods: {
    save () {
      let labwork =
        {
          number: this.number,
          name: this.name,
          task: this.task
        }
      this.$http.post('api/labwork', labwork)
        .then(response => response.json()
          .then(data => {
            this.cards.push(data)
          }))

      this.dialog = false
      this.number = ''
      this.name = ''
      this.task = ''
    },
    close () {
      this.dialog = false
    }
  }
}
</script>

<style scoped>

</style>
