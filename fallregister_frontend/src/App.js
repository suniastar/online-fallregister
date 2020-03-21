import React from 'react';
//import './App.css';
import './App_light.css';
import {Button} from '@material-ui/core/';
import PatientDataForm from "./PatientDataForm.js"
import CVSImportForm from './CVSImportForm.js';

class App extends React.Component {
    constructor(){
        super();
        this.state = {buttontext: "cvsimport"};
        this.onButtonClick = this.onButtonClick.bind(this);
    }

    onButtonClick(){
        if(this.state.buttontext === "cvsimport"){
            this.setState({buttontext: "manueller input"});
        }else{
            this.setState({buttontext: "cvsimport"});
        }
    }
    render(){
        let form= <h>oh oh</h>;
        if(this.state.buttontext === "cvsimport"){
            form = <PatientDataForm />;
        }else{
            form = <CVSImportForm />
        }

        return (
            <div className="App">
                <header className="App-header">
                <Button onClick={this.onButtonClick}>{this.state.buttontext}</Button>
                
                   {form}
                </header>
            </div>
        );
    }
    
}

export default App;
