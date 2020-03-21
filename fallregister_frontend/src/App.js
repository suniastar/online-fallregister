import React from 'react';
//import './App.css';
import './App_light.css';
import {Button} from '@material-ui/core/';
import PatientDataForm from "./PatientDataForm.js"
import CSVImportForm from './CSVImportForm.js';

class App extends React.Component {
    constructor(){
        super();
        this.state = {buttontext: "csvimport"};
        this.onButtonClick = this.onButtonClick.bind(this);
    }

    onButtonClick(){
        if(this.state.buttontext === "csvimport"){
            this.setState({buttontext: "manueller input"});
        }else{
            this.setState({buttontext: "csvimport"});
        }
    }
    render(){
        let form= <h>oh oh</h>;
        if(this.state.buttontext === "csvimport"){
            form = <PatientDataForm />;
        }else{
            form = <CSVImportForm />
        }

        return (
            <div className="App">
                <header className="App-header">
                    <div class='left'>
                        <Button onClick={this.onButtonClick}>{this.state.buttontext}</Button>
                        </div>
            <div class='right'>
                        <Button onClick={this.Logout}>Logout</Button>
            </div>
                </header>
                {form}
            </div>
        );
    }
    
}

export default App;
