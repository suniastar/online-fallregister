
import React from 'react';

import {FormLabel, Input, Grid, Button, makeStyles, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper} from '@material-ui/core/';
import MaterialTable from 'material-table';

class CSVImportForm extends React.Component {

    render() {
        function createData(id, firstName, lastName, dateOfBirth, gender, suspected, diagnosis,
                            death, dateOfDeath, dateOfSick, dateOfDiagnosis, medicalField, foodField,
                            workCare, inCare, inHospitalSince, inIntensiveCareSince, nameAndPlace, placeOfInfection, sourceOfInfection) {
            return {id, firstName, lastName, dateOfBirth, gender, suspected, diagnosis,
                death, dateOfDeath, dateOfSick, dateOfDiagnosis, medicalField, foodField,
                workCare, inCare, inHospitalSince, inIntensiveCareSince, nameAndPlace, placeOfInfection, sourceOfInfection};
        }

        const rows = [
            createData(1, "Max", "Mustermann", "01.01.1999", "männlich",
                "Nein", "Ja", "Nein", "-", "15.03.2020",
                "20.03.2020", "Nein", "Nein", "Nein", "Nein", "-",
                "-", "-", "unbekannt", "unbekannt"),

            createData(2, "Maria", "Musterfrau", "06.09.1970", "weiblich",
                "Nein", "Ja", "Nein", "-", "8.03.2020",
                "16.03.2020", "Nein", "Nein", "Nein", "Nein", "17.03.2020",
                "19.03.2020", "-", "unbekannt", "unbekannt"),

            createData(3, "Paula", "Mustermann", "06.07.1998", "weiblich",
                "Nein", "Ja", "Nein", "-", "20.03.2020",
                "21.03.2020", "Ja", "Nein", "Nein", "Nein", "-",
                "-", "Pflegeheim Muster", "zu Hause", "Max Mustermann")
        ];

        return(
            <form action="/action_page.php">
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
                            {rows.map(row => (
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

export default CSVImportForm;

