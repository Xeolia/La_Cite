//STORE
const store = new Vuex.Store({
    token: "null",
    id: '',
    username: '',
    name: '',
    mail: '',
    mutations: {
        getCookie() {
            if($cookies.get('token')){
                cookie = JSON.parse($cookies.get('token'));
                console.log("store | getcookie() | valeur token | " + cookie);
                store.token = cookie;
                return cookie;
            }else{
                console.log("store | getCookie() | aucun cookie dans le navigateur");
                return null;
            }
        }
    }
})


// HOME
const Home = {
    template: '#home',
    name: 'Home',
    data:() => {
        return {
            index: '124',
            token: "",
            id: '',
            username: '',
            pseudo: '',
            mail: '',
        }
    },
    methods: {
        getUser() {
            if (store.token == "" || store.token == "null"){
                console.log("Home | getUser() | aucun token dans le store");
            }else{
                console.log("Home | getUser() | valeur token | " + store.token);
                fetch("http://localhost:8085/user", {
                method: 'GET',
                headers: {
                    'Authorization': 'Bearer ' + store.token,
                }})
                .then( response => {
                    response.json().then(data => {
                    console.log(data);
                    this.id = data.id;
                    this.username = data.username;
                    this.pseudo = data.name;
                    this.mail = data.email;
                    console.log("Home | getUser() | fin du traitement de la réponse de la requête");
                    return true;
                    })})
            }
        }
    },
    mounted(){
        store.commit('getCookie');
        this.getUser();
        console.log("before while");
        this.token = store.token;
        //new Promise(resolve => setTimeout(resolve, 2000));
        //console.log("Home | mounted() | valeur result | " + result)
        console.log("Home | mounted() | username store : " + store.username + " | name store : " + store.name + " | mail store : " + store.mail);

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