const express = require('express');
const app = express();

let names = ['Home', 'Posts', 'Error404','Conatact'];

//register th ejs view engine
app.set('view engine', 'ejs');

// listen for requests on port 3000
app.listen(3000);

/*On doit mentionner le dossier views pour utiliser le CSS file*/

app.use(express.static(__dirname + '/views'));

app.get('/', (req, res) => {

    res.render('index');
});

app.get('/posts',(req,res) =>{
    

    let posts = [
        { id: 1, title: 'Charles Dickens', body: 'A Tale of Two Cities' },
        { id: 2, title: 'William Shakespeare', body: 'Macbeth' },
              ];
    res.render('posts', {posts: posts});
});

app.get('/contactus',(req,res) => {
    
    res.render('contactus');
});



// We will discuss this method next week, when we speak about Middlewares
app.use((req, res) => {
    
    res.status(404).render('404');
    
})