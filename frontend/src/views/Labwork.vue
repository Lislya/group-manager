<template>
    <v-layout fullheight column>
        <labwork-add-button :cards="cards"></labwork-add-button>
        <labwork-table :cards="cards"></labwork-table>
    </v-layout>
</template>

<script>
import LabworkTable from '@/components/labwork/LabworkTable'
import LabworkAddButton from '@/components/labwork/LabworkAddButton'
export default {
  name: 'Labwork',
  components: {
    LabworkTable,
    LabworkAddButton
  },
  data () {
    return {
      cards: []
    }
  },
  created () {
    this.$http.get('/api/labwork')
      .then(result => result.json()
        .then(data => data.forEach(student => this.cards.push(student))))
  }
}
</script>

<style scoped>

</style>
