import React, { useState, useRef, useEffect} from 'react';
import Todolist from './Todolist';
import './app.css';

import {uuid, v4 as uuidv4} from 'uuidv4';


function App() {

  const [todos, setTodos] = useState([])
  const todoNameRef = useRef()




function handleAddTodo(e){
  const name = todoNameRef.current.value
  if ( name === '') return
  setTodos(prevTodos => {
    return[...prevTodos, { id : uuid(), name: name, complete:false}]
  })
    todoNameRef.current.value = null
  }


function handleClearTodos(){
  const newTodos = todos.filter(todo => !todo.complete)
  setTodos(newTodos)
}



function toggleTodo(id){
  const newTodos = [...todos]
  const todo = newTodos.find(todo => todo.id === id)
  todo.complete = !todo.complete
  setTodos(newTodos)
}



  return (
    <div class="container">
      <div class="content">
        <Todolist  todos={todos} toggleTodo={toggleTodo}/>
        <input  ref={todoNameRef}  type="text"/>
        <button onClick={handleAddTodo}>Add Todo</button>
        <button onClick={handleClearTodos}>Clear Complete</button>
        <div>{todos.filter(todo => !todo.complete).length} left to do</div>
      </div>
    </div>

  )
}

export default App;
