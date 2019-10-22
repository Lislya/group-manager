import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Student from '../views/Student'
import Team from '../views/Team'
import Labwork from '../views/Labwork'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/student',
    name: 'student',
    component: Student
  },
  {
    path: '/team',
    name: 'team',
    component: Team
  },
  {
    path: '/labwork',
    name: 'labwork',
    component: Labwork
  },
  {
    path: '*',
    name: 'home',
    component: Home
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
