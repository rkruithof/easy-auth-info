easy-auth-info
===========
[![Build Status](https://travis-ci.org/DANS-KNAW/easy-auth-info.png?branch=master)](https://travis-ci.org/DANS-KNAW/easy-auth-info)

<!-- Remove this comment and extend the descriptions below -->


SYNOPSIS
--------

    easy-auth-info (synopsis of command line parameters)
    easy-auth-info (... possibly multiple lines for subcommands)


DESCRIPTION
-----------

Provides consolidated authorization info about items in a bag store.


ARGUMENTS
---------

    Options:

        --help      Show help message
        --version   Show version of this program

    Subcommand: run-service - Starts EASY Auth Info as a daemon that services HTTP requests
        --help   Show help message
    ---

EXAMPLES
--------

    easy-auth-info -o value


INSTALLATION AND CONFIGURATION
------------------------------


1. Unzip the tarball to a directory of your choice, typically `/usr/local/`
2. A new directory called easy-auth-info-<version> will be created
3. Add the command script to your `PATH` environment variable by creating a symbolic link to it from a directory that is
   on the path, e.g. 
   
        ln -s /usr/local/easy-auth-info-<version>/bin/easy-auth-info /usr/bin



General configuration settings can be set in `cfg/application.properties` and logging can be configured
in `cfg/logback.xml`. The available settings are explained in comments in aforementioned files.


BUILDING FROM SOURCE
--------------------

Prerequisites:

* Java 8 or higher
* Maven 3.3.3 or higher

Steps:

        git clone https://github.com/DANS-KNAW/easy-auth-info.git
        cd easy-auth-info
        mvn install
