const http = require('http');
const fs = require('fs');
const server = http.createServer((req, res) => {
    res.setHeader('Content-Type', 'text/html');
    let path = './views/'
    switch (req.url) {
        case '/':
          path += 'index.html';
          break;
        case '/posts':
          path += 'posts.html';
          break;
        case '/contactus':
           path += 'contactus.html';
            break;
        default:
          path += '404.html';
           break;
    }
    fs.readFile(path, (err, data) => {
        if (err) {
             console.log(err);
        } else {
             res.write(data);
            res.end();
    }
    })
});
server.listen(3000, 'localhost', () => {
    console.log('I am listing for requests on port 3000');
    console.log('I am still listing for requests on port 3000');
});
