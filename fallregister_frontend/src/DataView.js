
import React from 'react';

import {Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Button, Paper} from '@material-ui/core/';

class DataView extends React.Component {  

    constructor(){
        super();

        this.goToReal = this.goToReal.bind(this);
        this.goToSample = this.goToSample.bind(this);
        const rows = [
            this.createData(1, "Max", "Mustermann", "01.01.1999", "männlich",
                "Nein", "Ja", "Nein", "-", "15.03.2020",
                "20.03.2020", "Nein", "Nein", "Nein", "Nein", "-",
                "-", "-", "unbekannt", "unbekannt"),

                this.createData(2, "Maria", "Musterfrau", "06.09.1970", "weiblich",
                "Nein", "Ja", "Nein", "-", "8.03.2020",
                "16.03.2020", "Nein", "Nein", "Nein", "Nein", "17.03.2020",
                "19.03.2020", "-", "unbekannt", "unbekannt"),

                this.createData(3, "Paula", "Mustermann", "06.07.1998", "weiblich",
                "Nein", "Ja", "Nein", "-", "20.03.2020",
                "21.03.2020", "Ja", "Nein", "Nein", "Nein", "-",
                "-", "Pflegeheim Muster", "zu Hause", "Max Mustermann"),

                this.createData(4, "Maximilian", "Mannmuster", "18.10.1959", "männlich",
                "Nein", "Ja", "Ja", "22.03.2020", "05.03.2020",
                "14.03.2020", "Nein", "Nein", "Nein", "Ja", "14.03.2020",
                "16.03.2020", "Pflegeheim Muster", "Pflegeheim Muster", "Paula Mustermann"),

                this.createData(5, "Franziska", "Fraumuster", "18.10.1970", "weiblich",
                "Ja", "Nein", "Nein", "-", "09.03.2020",
                "-", "Nein", "Ja", "Nein", "Nein", "-",
                "-", "Supermarkt Muster", "unbekannt", "unbekannt"),

                this.createData(6, "Maja", "Muster", "15.01.1981", "weiblich",
                "Nein", "Ja", "Nein", "-", "07.03.2020",
                "11.03.2020", "Nein", "Nein", "Nein", "Nein", "-",
                "-", "-", "unbekannt", "unbekannt")
        ];
        this.state = {buttontext: "sample",
        srows: rows,
        rrows:[]};
        fetch('http://localhost:8080/infected')
        .then(res => res.json())
        .then(
          (data) => {
              const rows = data.map((curr,ind) => this.createData(ind,curr.firstName,curr.lastName, curr.dateOfBirth, curr.gender,"","","","","","","","","","","","","","","","","","","","","","",""))
  
              if(rows){
                this.setState({rrows: rows})
              }else{
                this.setState({rrows:   [this.createData(6, "Maja", "Muster", "15.01.1981", "weiblich",
                "Nein", "Ja", "Nein", "-", "07.03.2020",
                "11.03.2020", "Nein", "Nein", "Nein", "Nein", "-",
                "-", "-", "unbekannt", "unbekannt")]})
              }
              

          },
        )
    }

    goToSample(){
        this.setState({buttontext: "sample"});
    }

    goToReal(){
        this.setState({buttontext: "real"});
    }
    createData(id, firstName, lastName, dateOfBirth, gender, suspected, diagnosis,
        death, dateOfDeath, dateOfSick, dateOfDiagnosis, medicalField, foodField,
        workCare, inCare, inHospitalSince, inIntensiveCareSince, nameAndPlace, placeOfInfection, sourceOfInfection) {
return {id, firstName, lastName, dateOfBirth, gender, suspected, diagnosis,
death, dateOfDeath, dateOfSick, dateOfDiagnosis, medicalField, foodField,
workCare, inCare, inHospitalSince, inIntensiveCareSince, nameAndPlace, placeOfInfection, sourceOfInfection};
}

    render() {   
        const myrows = this.state.buttontext === "sample" ? this.state.srows : this.state.rrows;
        console.log(myrows)
        return(
            <form action="/action_page.php">
                 <Button onClick={this.goToReal} color="primary"
                            variant={this.state.buttontext === "real" ? "contained" : ""}>"echte" Daten</Button>
                <Button onClick={this.goToSample} color="primary"
                            variant={this.state.buttontext === "sample" ? "contained" : ""}>sample Daten</Button>
                <TableContainer component={Paper}>
                    <Table size="small" aria-label="a dense table">
                        <TableHead>
                            <TableRow>
                                <TableCell>Id</TableCell>
                                <TableCell>Vorname</TableCell>
                                <TableCell>Nachname</TableCell>
                                <TableCell>Geburtsdatum</TableCell>
                                <TableCell>Geschlecht</TableCell>
                                <TableCell>Verdacht</TableCell>
                                <TableCell>Diagnose</TableCell>
                                <TableCell>Tod</TableCell>
                                <TableCell>Todesdatum</TableCell>
                                <TableCell>Erkrankungsbeginn</TableCell>
                                <TableCell>Diagnosedatum</TableCell>
                                <TableCell>im medizinischen Bereich taetig</TableCell>
                                <TableCell>im Lebensmittelbereich taetig</TableCell>
                                <TableCell>in Gemeinschaftseinrichtung taetig</TableCell>
                                <TableCell>in Gemeinschaftseinrichtung betreut</TableCell>
                                <TableCell>in Krankenhaus/Pflegeeinrichtung seit</TableCell>
                                <TableCell>auf der Intensivstation seit</TableCell>
                                <TableCell>Name und Ort der Einrichtung</TableCell>
                                <TableCell>Wahrscheinlicher Infektionsort</TableCell>
                                <TableCell>Wahrscheinliche Infektionsquelle</TableCell>

                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {myrows.map(row => (
                                <TableRow key={row.id}>
                                    <TableCell component="th" scope="row">
                                        {row.id}
                                    </TableCell>
                                    <TableCell>{row.firstName}</TableCell>
                                    <TableCell>{row.lastName}</TableCell>
                                    <TableCell>{row.dateOfBirth}</TableCell>
                                    <TableCell>{row.gender}</TableCell>
                                    <TableCell>{row.suspected}</TableCell>
                                    <TableCell>{row.diagnosis}</TableCell>
                                    <TableCell>{row.death}</TableCell>
                                    <TableCell>{row.dateOfDeath}</TableCell>
                                    <TableCell>{row.dateOfSick}</TableCell>
                                    <TableCell>{row.dateOfDiagnosis}</TableCell>
                                    <TableCell>{row.medicalField}</TableCell>
                                    <TableCell>{row.foodField}</TableCell>
                                    <TableCell>{row.workCare}</TableCell>
                                    <TableCell>{row.inCare}</TableCell>
                                    <TableCell>{row.inHospitalSince}</TableCell>
                                    <TableCell>{row.inIntensiveCareSince}</TableCell>
                                    <TableCell>{row.nameAndPlace}</TableCell>
                                    <TableCell>{row.placeOfInfection}</TableCell>
                                    <TableCell>{row.sourceOfInfection}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>

            </form>
        );
        }
}

export default DataView;

