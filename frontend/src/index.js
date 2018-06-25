import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import { BrowserRouter } from 'react-router-dom'
import { MuiThemeProvider, createMuiTheme } from "@material-ui/core/styles";


const theme = createMuiTheme({
    palette: {
        primary: {
            main: "#900000",
            light: "#c8412a"
        },
        secondary: { main: "#DDDDDD" },
        error: {
            main: "#f44336",
            light: "#e5c9ca"
        }
    },
    typography: {
        // Fix relative font-size according to <html> element font-size set in index.css
        fontSize: 14, // Account for base font-size of 87.5%.
        htmlFontSize: 14 // 87.5% of 16px = 14px
    },
    overrides: {
        MuiListSubheader: {
            root: {
                fontSize: "1rem",
                color: "grey",
                fontWeight: 500
            }
        },
        MuiTypography: {
            subheading: {
                fontSize: "1rem",
                color: "grey",
                fontWeight: 500
            }
        }
    }
});

ReactDOM.render((
    <MuiThemeProvider theme={theme}>
        <BrowserRouter>
            <App />
        </BrowserRouter>
    </MuiThemeProvider>
), document.getElementById('root'))

registerServiceWorker();
