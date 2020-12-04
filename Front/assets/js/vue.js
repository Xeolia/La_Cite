//STORE
const store = new Vuex.Store({
    token: "",
    mutations: {
        getCookie() {
            if($cookies.get('token')){
                cookie = JSON.parse($cookies.get('token'));
                console.log("store | getcookie() | valeur token | " + cookie);
                store.token = cookie;
                return cookie;
            }else{
                console.log("il n'y a pas de cookie token");
                return null;
            }
        },
    }
})


// HOME
const Home = {
    template: '#home',
    name: 'Home',
    data:() => {
        return {
            index: '124'
        }
    },
    methods: {

    },
    mounted(){
        store.commit('getCookie');
        
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
        getUser() {
            var username = document.getElementById("username_login").value;
            var password = document.getElementById("password_login").value;
            console.log("username : " + username + "\npassword : " + "\n");

            fetch('http://127.0.0.1:8085/user/authentification', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({username: username, password: password})
            })
            .then(response => {
                response.json().then(data => {
                    console.log(data);
                    if(response.status == 200){
                        $cookies.set('token', JSON.stringify(data.token));
                        this.$router.push({ path: '/'});
                    }else{
                        alert("Bad password");
                    }
                })
            })
        }
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
        postUser: async() => {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var mail = document.getElementById("mail").value;
            var name = document.getElementById("name").value;
            console.log("username : " + username + "\npassword : " + "\nname : " + name + password + "\nname : " + name + '\nmail : ' + mail);

            const rawResponse = await fetch('http://127.0.0.1:8085/user/registration', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({username: username, name: name, password: password, mail: mail})
            });

            const content = await rawResponse.json();
            console.log(content)
        }
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