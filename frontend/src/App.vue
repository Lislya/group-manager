<template>
    <div id="app">
        <v-app id="inspire">
            <v-navigation-drawer
                v-model="drawer"
                app
                right>
                <v-list dense>
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title>
                                <v-btn text to="/">Главная</v-btn>
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title>
                                <v-btn text to="/team">Моя бригада</v-btn>
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title>
                                <v-btn text to="/student">Сипсок студентов</v-btn>
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list>
            </v-navigation-drawer>

            <v-app-bar
                app
                color="base"
                dark
            >
                <v-spacer></v-spacer>
                <v-toolbar-title>Лабораторный практикум</v-toolbar-title>
                <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
            </v-app-bar>

            <v-content>
                <v-container
                    fluid
                    fill-height
                >
                    <router-view></router-view>
                </v-container>
            </v-content>

            <v-footer
                color="grey darken-4"
                app
            >
                <v-spacer></v-spacer>
                <span class="white--text">&copy; 2019</span>
            </v-footer>
        </v-app>
    </div>
</template>

<script>
import HelloWorld from './components/HelloWorld'
import Student from './views/Student'

export default {
  name: 'App',
  components: {
    HelloWorld,
    Student
  },
  data: () => ({
    drawer: null
  })
}
</script>
