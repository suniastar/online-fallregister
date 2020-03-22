
import React from 'react';

import {FormLabel, Input, Grid, Button} from '@material-ui/core/';

class CSVImportForm extends React.Component {
    render(){

        return(
            <form action="/action_page.php">
            <Grid container direction='column' justify="center">

            <Grid Grid spacing={2}>
                <h>CSV Import</h>
            </Grid>

            <Grid>
                <input type="file" id="csvFile" name="csvFile"></input>
            </Grid>
                <Button type="submit" value="Submit" variant="contained" color="primary" m={2}>Dokument hochladen</Button>
            </Grid>
            </form>
    );
    }
}

export default CSVImportForm;