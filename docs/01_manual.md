---
title: Manual
layout: home
---

easy-auth-info
===========
[![Build Status](https://travis-ci.org/DANS-KNAW/easy-auth-info.png?branch=master)](https://travis-ci.org/DANS-KNAW/easy-auth-info)


SYNOPSIS
--------

    easy-auth-info run-service # Runs the program as a service
    easy-auth-info <item-id> # Retrieves the information from the cache or directly from the bag-store


DESCRIPTION
-----------
Provides consolidated authorization info about items in a bag store.


ARGUMENTS
---------

     -h, --help      Show help message
     -v, --version   Show version of this program
    
     trailing arguments:
      path (not required)
    
    Subcommand: run-service - Starts EASY Auth Info as a daemon that services HTTP requests
      -h, --help   Show help message
    ---

EXAMPLES
--------

```jshelllanguage
easy-auth-info 40594b6d-8378-4260-b96b-13b57beadf7c/data/pakbon.xml
curl 'http://localhost:20170/40594b6d-8378-4260-b96b-13b57beadf7c/data/pakbon.xml'
```

```json
{
  "itemId":"40594b6d-8378-4260-b96b-13b57beadf7c/data/pakbon.xml",
  "owner":"someone",
  "dateAvailable":"1992-07-30",
  "accessibleTo":"KNOWN",
  "visibleTo":"KNOWN"
}
```

INSTALLATION AND CONFIGURATION
------------------------------

### Depending on services

* [easy-bag-store](https://github.com/DANS-KNAW/easy-bag-store/)

### Security advice

Keep everything behind the firewall. Services like download and search will need access to the main
servlet implementing the `GET` methods. Only emergency fixes will need access to the update servlet
implementing the `DELETE` methods. Unintentional deletes won't hurt functionality but might have a
performance penalty.

### Performance advice

Keeping the default `solr.url` and `solr.core` in the `application.properties` while not having the
solr core up and running, will slow down the service even more than omitting the properties
as it will try to read and update each request in the solr cache.


BUILDING FROM SOURCE
--------------------

Prerequisites:

* Java 8 or higher
* Maven 3.3.3 or higher
* RPM

Steps:

        git clone https://github.com/DANS-KNAW/easy-auth-info.git
        cd easy-auth-info
        mvn install

If the `rpm` executable is found at `/usr/local/bin/rpm`, the build profile that includes the RPM
packaging will be activated. If `rpm` is available, but at a different path, then activate it by using
Maven's `-P` switch: `mvn -Pprm install`.
