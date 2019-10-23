<template>
    <v-container fluid>
        <v-row dense justify="start">
            <v-col
                v-for="card in cards"
                :key="card.id"
                :cols="4"
            >
                <labwork-card
                    :card="card"
                    @removeLabwork="removeLabworkFromTable"
                ></labwork-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
import LabworkCard from './LabworkCard'
export default {
  name: 'LabworkTable',
  props: ['cards'],
  components: {
    LabworkCard
  },
  methods: {
    removeLabworkFromTable (labwork) {
      this.$resource('api/labwork/{id}')
        .delete({ id: labwork.id })
        .then(response => {
          if (response.ok) {
            this.cards.splice(this.cards.indexOf(labwork), 1)
          }
        })
    }
  }
}
</script>

<style scoped>

</style>
