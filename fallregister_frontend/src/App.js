import React from 'react';
//import './App.css';
import './App_light.css';
import {Button} from '@material-ui/core/';
import PatientDataForm from "./PatientDataForm.js"
import CSVImportForm from './CSVImportForm.js';
import LoginForm from "./LoginForm"
import DataView from "./DataView"

class App extends React.Component {
    constructor(){
        super();
        this.state = {buttontext: "manual"};
        this.goToManual = this.goToManual.bind(this);
        this.goToCsvImport = this.goToCsvImport.bind(this);
        this.goToView = this.goToView.bind(this);
    }

    goToManual(){
        this.setState({buttontext: "manual"});
        }

    goToCsvImport(){
        this.setState({buttontext: "csvimport"});
    }

    goToView(){
        this.setState({buttontext: "view"});
    }

    render(){
        let form= <h>oh oh</h>;
        if(this.state.buttontext === "manual"){
            form = <PatientDataForm />;
        }else if(this.state.buttontext === "csvimport") {
            form = <CSVImportForm/>;
        }else if(this.state.buttontext === "view") {
            form = <DataView/>;
        }else{
            form = <LoginForm />
        }

        return (
            <div id="App">
                <header className="App-header">
                    <div class='alignleft'>
                        <Button onClick={this.goToManual} color="primary"
                            variant={this.state.buttontext == "manual" ? "contained" : ""}>Manueller Input</Button>
                    </div>
                    <div class='alignleft'>
                    <Button onClick={this.goToCsvImport} color="primary"
                        variant={this.state.buttontext == "csvimport" ? "contained" : ""}>CSV Import</Button>
                    </div>
                    <div class='alignleft'>
                    <Button onClick={this.goToView} color="primary"
                        variant={this.state.buttontext == "view" ? "contained" : ""}>Datenansicht</Button>
                    </div>
                    <div class='alignright'>
                        <Button onClick={this.Logout}>Logout</Button>
                    </div>
                </header>
                <div class='App-main'>
                    {form}
                </div>
            </div>
        );
    }
    
}

export default App;
