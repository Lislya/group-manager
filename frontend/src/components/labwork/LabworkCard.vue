<template>
    <v-card>
        <v-img
            :src="card.imgCover"
            class="white--text align-end"
            gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
            height="200px"
        >
            <v-card-title>{{ card.name }}</v-card-title>
            <v-card-subtitle light>Лаборатораная работа №{{ card.number }}</v-card-subtitle>
        </v-img>

        <v-divider></v-divider>

        <v-card-actions>
            <v-btn icon color="success">
                <v-icon large>mdi-plus-circle</v-icon>
            </v-btn>

            <v-btn icon color="blue" @click="editLabwork">
                <v-icon large>mdi-pencil-circle</v-icon>
            </v-btn>

            <v-spacer></v-spacer>

            <v-btn icon @click="removeCard">
                <v-icon large color="red">mdi-delete-circle</v-icon>
            </v-btn>
        </v-card-actions>

        <v-card-text>
            {{ card.task }}
        </v-card-text>
    </v-card>
</template>

<script>
export default {
  name: 'LabworkCard',
  props: ['card'],
  data () {
    return {
    }
  },
  methods: {
    removeCard () {
      this.$emit('removeLabwork', this.card)
    }
  }
}
</script>

<style scoped>

</style>
