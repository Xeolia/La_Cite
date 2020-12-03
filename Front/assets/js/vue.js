
// HOME
const Home = {
    template: '#home',
    name: 'Home',
    data:() => {
        return {

        }
    },
    methods: {

    }
};

// LOGIN
const Login = {
    template: '#login',
    name: 'Login',
    data:() => {
        return {

        }
    },
    methods: {
        
    }
};

// SIGN UP
const SignUp = {
    template: '#sign-up',
    name: 'SignUp',
    data:() => {
        return {

        }
    },
    methods: {
        
    }
};

// SPOTS
const Spots = {
    template: '#spots',
    name: 'Spots',
    data:() => {
        return {

        }
    },
    methods: {
        
    }
};



//ROUTER
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