
//
const Home = {
    template: '<h1>HOME PAGE</h1>',
    name: 'Home'
};

//
const Login = {
    template: '<h1>Connecte toi</h1>',
    name: 'Login'
};

//
const SignUp = {
    template: '<h1>Inscrit toi ici !</h1>',
    name: 'SignUp'
};

//
const Spots = {
    template: '<h1>Trouve ton spot de la journée !</h1>',
    name: 'Spots'
};



//router
const router = new VueRouter({
    routes: [
        { path: '/', component: Home, name: 'Home' },
        { path: '/login', component: Login, name: 'Login' },
        { path: '/sign-up', component: SignUp, name: 'SignUp' },
        { path: '/spots', component: Spots, name: 'Spots' },
    ]
});


const vue = new Vue({
    router
}).$mount("#app");