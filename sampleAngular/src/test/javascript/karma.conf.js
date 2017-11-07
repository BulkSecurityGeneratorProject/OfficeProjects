const webpackConfig = require('../../../webpack/webpack.test.js');
var SlKarma = require('../../../node_modules/.bin/slnodejs').SlKarma;

const WATCH = process.argv.indexOf('--watch') > -1;

module.exports = (config) => {
    config.set({

        // base path that will be used to resolve all patterns (eg. files, exclude)
        basePath: './',
        plugins: ["karma-*", SlKarma],
        
  
        // frameworks to use
        // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
        frameworks: ['jasmine', 'sealights'],

        // list of files / patterns to load in the browser
        files: [
            'spec/entry.ts'
        ],

        webpackServer: {
            noInfo: true
        },
        htmlReporter: {
            outputFile: 'coverage/units.html'
        },
        // list of files to exclude
        exclude: [],

        // preprocess matching files before serving them to the browser
        // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
        preprocessors: {
            'spec/entry.ts': ['webpack', 'sourcemap']
        },

        webpack: webpackConfig(WATCH),

        // test results reporter to use
        // possible values: 'dots', 'progress'
        // available reporters: https://npmjs.org/browse/keyword/karma-reporter
        reporters: ['dots', 'junit', 'progress', 'karma-remap-istanbul', 'notify', 'coverage', 'sealights', 'html'],

        junitReporter: {
            outputFile: '../../../../target/test-results/karma/TESTS-results.xml'
        },

        notifyReporter: {
            reportEachFailure: true, // Default: false, will notify on every failed sepc
            reportSuccess: true // Default: true, will notify when a suite was successful
        },


        remapIstanbulReporter: {
            reports: { // eslint-disable-line
                'html': 'target/test-results/coverage',
                'text-summary': null
            }
        },

        // web server port
        port: 9876,

        // enable / disable colors in the output (reporters and logs)
        colors: true,

        // level of logging
        // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
        logLevel: config.LOG_INFO,

        // enable / disable watching file and executing tests whenever any file changes
        autoWatch: WATCH,

        // start these browsers
        // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
        browsers: ['PhantomJS'],

        // Ensure all browsers can run tests written in .ts files
        mime: {
            'text/x-typescript': ['ts','tsx']
        },

        // Continuous Integration mode
        // if true, Karma captures browsers, runs the tests and exits
        singleRun: !WATCH,
        browserNoActivityTimeout: 30000,
        sealights: {
          testStage: "Unit Tests",
          token: "eyJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL1BST0QtQ1VTVE9NRVJTMi5hdXRoLnNlYWxpZ2h0cy5pby8iLCJqd3RpZCI6IlBST0QtQ1VTVE9NRVJTMixpLTBkZDQ4ZTgyZDNhNGY0MWFhLEFQSUdXLTBiMzk4Mzg1LWI0ZjYtNGU3OS1iM2UyLTMyZTBjMGZmNDJhNywxNTA5OTU3NzE5MzAwIiwic3ViamVjdCI6ImhleGF3YXJlQGFnZW50IiwiYXVkaWVuY2UiOlsiYWdlbnRzIl0sIngtc2wtcm9sZSI6ImFnZW50IiwieC1zbC1zZXJ2ZXIiOiJodHRwczovL1BST0QtQ1VTVE9NRVJTMi1ndy5zZWFsaWdodHMuY28vYXBpIiwic2xfaW1wZXJfc3ViamVjdCI6IiIsImlhdCI6MTUwOTk1NzcxOX0.cyRa1wrkCMAVd0JTToYna4yC6JaBRPGL4RHjuM_mAPGwNAoEtMJdx2knxxjGi1urpzILvgWOxSwPng3cg_KnNOPM74U6yXMD5VSdm9pwl7TJUGlgb-4noKnpMNyKL6G4nfhVSfe49-ioOuv7Nks_uRf1offbdGr3NTjk_ZBg_0hteD62weilxe-3nrCeoSnnWPDYmjPoNiMoyWiqEr79kdnovh7yRByYY7IWHB2hqWRVKFGSyiWy4dO874L1_mkl0685gHrdfv1vQbGTsIqvmVXA6iP25aDhoH3WHbvMvrYwEF-jr36yLzztnNn6uUB4xRiXbuyJ69UQx_RaiD80uy-DnwzlOs23na_UXSQqMOITp_ifjB4k6R6uF9HseaSc7XJg6yX6X9txnv_Fc18wggSyZ1wnKI8AbBbIuB5Fwi66EH8yF66fetOLNGpOFYXLIApRAQ48UdEZ539Ktuld4u-TSK9BnYnHSm-TU9-waQKTzY7PIF985zKYp2qthSqXbSs_7RZMWuiOzy_601Is1d5PdhjzFfaSNCdetCpJd2zdDbhQ-GeDCyV86OppEK7PQfpq0fwLY8EWFVhOkK2gw-BssWtXwgSwX23QDot9aJjpIgQG2-q3aD8iVm_wlchnW-om-UQlA3P8PMD_Q-c03DhOORjYZbcaq1Ju_Atqvds",
          buildSessionid: "e9b5a4632b1b1f28a8b285a27cc1455c",
          resolveWithoutHash: true,
          workspacepath: "."
        }
    });
};
