import React from 'react';
//import './App.css';
import './App_light.css';
import PatientDataForm from "./PatientDataForm.js"

class App extends React.Component {
    render(){
        return (
            <div className="App">
                <header className="App-header">
                   <PatientDataForm />
                </header>
            </div>
        );
    }
    
}

export default App;
