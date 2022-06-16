const Pool = require('pg').Pool;

const pool = new Pool({
    user: "postgres",
    password: "2201",
    database: "ASEDS",
    host: "localhost",
    port: "5432"
});

module.exports=pool;