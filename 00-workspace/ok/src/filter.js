import React, {useEffect} from "react";


function Filter({setActiveGenre, activeGenre, setFiltered, popular}){
    
    useEffect(() => {
        if( activeGenre === 0) {
            setFiltered(popular);
            return;
        }
        const filtered = popular.filter((movie) =>
        movie.genre_ids.includes(activeGenre));
        setFiltered(filtered);
    },[activeGenre])
    
    return(
        <div>
            <button onClick={() => setActiveGenre(0)}>All</button>
            <button onClick={() => setActiveGenre(35)}>Comedy</button>
            <button onClick={() => setActiveGenre(28)}>Action</button>
        </div>

    )   
}

export default Filter;

