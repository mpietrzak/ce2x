# ce2x

EDI 2 XML, based on https://github.com/zubairov/edi-to-xml/

## Why

Because I find compilling original edi-to-xml way too hard and I wanted to be able to
quickly tune/make changes to the code by myself.

## What

EDI and UN/Edifact are, generally speaking, file format and protocol
used to encode electronic documents like Orders, Invoices and Shipping
Documents.

Some resources:

- https://en.wikipedia.org/wiki/Electronic_data_interchange
- https://en.wikipedia.org/wiki/EDIFACT
- https://en.wikipedia.org/wiki/AS2
- https://www.unece.org/cefact/edifact/
- https://www.unece.org/tradewelcome/un-centre-for-trade-facilitation-and-e-business-uncefact/outputs/standards/unedifact/directories/download.html

Smooks is a very awesome set of libraries dedicated to processing of various
file formats and protocols, including EDI and UN/Edifact formats.

See more here: https://github.com/smooks/smooks

This app bundles and exposes some of the Smooks libraries into trivial
Clojure web app. The web app might be useful when developing UN/Edifact
processing applications, e.g. to validate produced EDI files.

One and only functionality of the app is to accept EDI file (in text field
or as a file upload) and print parsed structure as XML.


## License

Copyright © 2014 Maciej Pietrzak
