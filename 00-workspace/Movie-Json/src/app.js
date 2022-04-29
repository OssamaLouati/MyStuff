import React, { useEffect, useState} from 'react';
import Movie from "./Movie.js";
import './app.css';
import Filter from "./filter";
import Navbar from "./navbar";
import { motion, AnimatePresence} from 'framer-motion/dist/framer-motion';

function app(){

    const [popular, setPopular] = useState([]);
    const [filtered, setFiltered] = useState([]);
    const [activeGnere, setActiveGenre] = useState(0);

    useEffect(() => {
        fetchPopular();
    }, []) //what's inside the square brackets is that whenever popular changes, useEffect renders it again

    const fetchPopular = async () => {
        const data = await fetch("https://api.themoviedb.org/3/movie/popular?api_key=e1c09de8426e4a7de602a757574ca45c&language=en-US&page=1");
        const movies = await data.json();
        console.log(movies);
        setPopular(movies.results);
        setFiltered(movies.results);
    };

    return(
        <>
        <div>
            <Navbar />
        </div>
            <div className="body-container">
            <div className="filter-container">
                <Filter  popular={popular} setFiltered={setFiltered} activeGenre={activeGnere} setActiveGenre={setActiveGenre}/>
        </div>

                <motion.div layout className="popular-movies">

                    <AnimatePresence>
                        {filtered.map(movie => {
                            return <Movie key={movie.id} movie={movie}/>;
                        })}
                    </AnimatePresence>
                </motion.div>
        </div>
        </>
    )
}
export default app 
