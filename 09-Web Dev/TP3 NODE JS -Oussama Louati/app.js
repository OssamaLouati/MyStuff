const express = require('express');
const pool = require('./database');

const app = express();

app.use(express.json());

//register the ejs view engine
app.set('view engine', 'ejs');

// listen for requests on port 3000
app.listen(3000, () =>{
    console.log("Server is listening to port 3000")
});

/*On doit mentionner le dossier views pour utiliser le CSS file*/

app.use(express.static(__dirname + '/views'));


app.get('/', (req, res) => {

    res.render('index');
});
/*
app.post('/posts', async(req,res) =>{
    try{
        const post =req.body;
        console.log("get posts request has arrived");
        const newpost = await pool.query(

           ' SELECT * FROM data WHERE id=$1 ',[1] 
           "INSERT INTO data(id, name) VALUES(£1, 'Z') RETURNING*", [post.id,post.name]
           // ' DELETE FROM "DATA1" WHERE id =$1',[id]
        );
        //res.redirect('posts');
        res.json(newpost);
    
    }catch (err){
        console.error(err.message);
    }
});*/

app.delete('/posts/:id', async(req, res) => {
    try {
    const { id } = req.params;
    const post = req.body;
    console.log("delete a post request has arrived");
    const deletepost = await pool.query(
        "DELETE FROM data WHERE id = $5", [id]
    );
    res.json(post);
    } catch (err) {
    console.error(err.message);
    }
});
 
   
app.get('/contactus',(req,res) => {
    
    res.render('contactus');
});


app.use((req, res) => {
    
    res.status(404).render('404');
    
})