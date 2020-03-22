
import React from 'react';

import {FormLabel, Input, Grid, Button, makeStyles, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper} from '@material-ui/core/';

class CSVImportForm extends React.Component {
    render(){

        return(
            <form action="/action_page.php">
                <TableContainer component={Paper}>
                    <Table aria-label="simple table">
                        <TableHead>
                            <TableRow>
                                <TableCell>Id</TableCell>
                                <TableCell>Vorname</TableCell>
                                <TableCell>Nachname</TableCell>
                                <TableCell>Geburtsdatum</TableCell>
                                <TableCell>Geschlecht</TableCell>
                                <TableCell>Verdacht</TableCell>
                                <TableCell>Klinische Diagnose</TableCell>
                                <TableCell>Tod</TableCell>
                                <TableCell>Todesdatum</TableCell>
                                <TableCell>Erkrankungsbeginn</TableCell>
                                <TableCell>Diagnosedatum</TableCell>
                                <TableCell>Patient/in im medizinischen Bereich taetig</TableCell>
                                <TableCell>Patient/in im Lebensmittelbereich taetig</TableCell>
                                <TableCell>Patient/in wird in Gemeinschaftseinrichtung betreut</TableCell>
                                <TableCell>Patient/in ist in Krankenhaus/Pflegeeinrichtung seit</TableCell>
                                <TableCell>Patient/in ist auf der Intensivstation seit</TableCell>
                                <TableCell>Name und Ort der Einrichtung</TableCell>
                                <TableCell>Wahrscheinlicher Infektionsort</TableCell>
                                <TableCell>Wahrscheinliche Infektionsquelle</TableCell>
                            </TableRow>
                        </TableHead>
                    </Table>
                </TableContainer>
            </form>
        );
    }
}

export default CSVImportForm;