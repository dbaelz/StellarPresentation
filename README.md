# About
Stellar Presentation is a basic presentation application for the desktop.
It's developed with [Compose for Desktop](https://github.com/JetBrains/compose-jb) and was initially 
created as showcase for my [talk at KKON 2021](https://rheinwerk-kkon.de/programm/baelz-compose-for-desktop/).
With the provided features, it's usable for presentations and also shows different concepts of Compose for Desktop.


The app already has some useful features:
- Navigation between slides with left/right arrows and home/end keys
- Supports fullscreen (F11). Right now with a hardcoded resolution
- Template slides that make it easy to create basic presentations
- A presentation can define the typography to use

# How to use Stellar Presentation
The easiest way is to create your own presentation in a presentation-specific branch.
Also, take a look at the [sample presentation](de/dbaelz/stellar/demo/DemoPresentation.kt) and
my extensive [presentation about Compose for Desktop](https://github.com/dbaelz/StellarPresentation/tree/presentation/KKON2021-ComposeForDesktop/src/main/kotlin/de/dbaelz/stellar/demo/kkon2021)
for examples how to create presentations with the app.

# TODOs and improvement ideas
There are several todos and improvement ideas for Stellar Presentation. For example:
- Adjust/scale the slides when the presentation isn't in full screen
- Window size as command-line argument
- More default/template slides
- Export of the presentation as PDF (with screenshots)
- Extract presentations from src/main (into a Gradle module?)
- Logo for Stellar Presentation (see source code TODOs)


# Contribution
Feel free to use the presentation app and to contribute to it via pull requests.

# License
Copyright (c) Daniel Bälz

All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

# Font License
- [Lato font](src/main/resources/fonts/lato) is licensed under
the [SIL Open Font License, Version 1.1](license/Lato/OFL.txt)
- [Caveat font](src/main/resources/fonts/caveat) is licensed under
the [SIL Open Font License, Version 1.1](license/Caveat/OFL.txt)
- [IndieFlower font](src/main/resources/fonts/indieflower) is licensed under
the [SIL Open Font License, Version 1.1](license/IndieFlower/OFL.txt)
- [Markazi Text font](src/main/resources/fonts/markazitext) is licensed under
the [SIL Open Font License, Version 1.1](license/MarkaziText/OFL.txt)