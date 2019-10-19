import Vue from 'vue'
import VueResource from 'vue-resource'
import router from './router'
import '@mdi/font/css/materialdesignicons.css'
import vuetify from './plugins/vuetify'
import App from './App.vue'

Vue.use(vuetify)
Vue.use(VueResource)

Vue.config.productionTip = false

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
