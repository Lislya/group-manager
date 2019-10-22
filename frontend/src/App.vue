<template>
    <div id="app">
        <v-app id="inspire">
            <v-navigation-drawer v-model="drawer" app right>
                <v-list dense>
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title>
                                <v-icon>mdi-home</v-icon>
                                <v-btn text small to="/">Главная</v-btn>
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title>
                                <v-icon>mdi-account-multiple</v-icon>
                                <v-btn text small to="/team">Моя бригада</v-btn>
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title>
                                <v-icon>mdi-format-list-checkbox</v-icon>
                                <v-btn small text to="/student">Сипсок студентов</v-btn>
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item>
                        <v-list-item-content>
                            <v-list-item-title>
                                <v-icon>mdi-flask</v-icon>
                                <v-btn text small to="/labwork">Лабораторные</v-btn>
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list>
            </v-navigation-drawer>

            <v-app-bar app color="base" dark>
                <v-spacer></v-spacer>
                <v-toolbar-title>Лабораторный практикум</v-toolbar-title>
                <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
            </v-app-bar>

            <v-content>
                <v-container fluid fill-height>
                    <router-view></router-view>
                </v-container>
            </v-content>

            <v-footer color="grey darken-4" app>
                <v-spacer></v-spacer>
                <span class="white--text">&copy; 2019 Kim Daniel</span>
            </v-footer>
        </v-app>
    </div>
</template>

<script>
import Student from './views/Student'

export default {
  name: 'App',
  components: {
    Student
  },
  data: () => ({
    drawer: null
  })
}
</script>
