<template>
    <v-layout fluid>
        <team-tabs></team-tabs>
    </v-layout>
</template>

<script>
import TeamTabs from '@/components/team/TeamTabs'
export default {
  name: 'Team',
  components: {
    TeamTabs
  },
  data () {
    return {

    }
  }
}
</script>

<style scoped>

</style>
