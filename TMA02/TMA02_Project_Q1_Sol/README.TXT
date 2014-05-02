//Don't forget to execute one statement at a time!
FitnessFrog ff1 = new FitnessFrog();
FitnessFrog ff2 = new FitnessFrog();
Coach c = new Coach(ff1, ff2);
c.train();
ff1.setPosition(0);
ff2.setPosition(12);
c.train();