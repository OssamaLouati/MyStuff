const express = require('express');
const app = express();
// listen for requests on port 3000
app.listen(3000);
/* app.get() is used to respond to Get requests, and it takes two arguments: 
1- arg1: represents what path/url you want to listen to (e.g., '/' listens to index path)
2- arg2: represents a function that takes in request and response objects */
app.get('/', (req, res) => {
/* res.sendFile() is a method that can be used to send files as its name indicates. However, it takes the absolute 
not the relative path to the file. Therefore, you need to specify the root directory of the file.
To avoid this confusion, you can use "__dirname", which you have access to after installing "lodash" */
 res.sendFile('./views/index.html', { root: __dirname });
});
app.get('/posts',(req,res) =>{
    res.sendFile('./views/posts.html', {root: __dirname});
});

app.get('/contactus',(req,res) => {
    res.sendFile('./views/contactus.html', {root: __dirname});
});



// We will discuss this method next week, when we speak about Middlewares
app.use((req, res) => {
 res.status(404).sendFile('./views/404.html', { root: __dirname });
})