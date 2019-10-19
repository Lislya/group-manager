<template>
  <div class="home">
    <HelloWorld msg="Система управления работы бригад во время проведения лабораторного практикума"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'home',
  components: {
    HelloWorld
  }
}
</script>
