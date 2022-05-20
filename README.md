# OhjelmointiProjekti
### Projektiryhmän kehitysrepo

Tämä repo on olemassa projektiyhteistyötä ja versionhallintaa varten

<br>
<br>

## Recommended order of Git commands:
  1. git status
  2. git pull
  4. git add <file names> &nbsp;// *Try to not use "git add ." and instead use git add <file path -> file name>. Otherwise it will be the whole repo.*
  5. git commit -m "A description of changes"
  6. git pull
  7. git push
  
### Useful Git commands:
  - git log    
  - git branch
  - git checkout
  - git init
  
#### Set Git username and email globally:
  - git config --global user.name "your_username"	
  - git config --global user.email "your_email_address@example.com"

<br>
<br>

### Step by step

#### 1.0 KLOONAAMISEEN repon koneellesi:    
1.1 Napsauta oikealla olevaa vihreää koodipainiketta, valitse HTTPS, kopioi URL-osoite   
1.2 Ava sun tietokoneen terminaali/GitBash, kirjoita git clone, liitä sitten kopioimasi URL-osoite ja paina enter    

#### 3.0 TYÖSKENTELEMISEEN repossa:   
3.1 Luo uusi tiedosto, esim. tiedoston_nimi.php     
3.2 Koodaa    
3.3 Vasemmassa yläkulmassa olevasta file, valitse save    

#### 4.0 PUSHAMAAN/PULLAMAAN työtä repossa:      
4.1 Kirjoita: git status   
4.2 Kirjoita: git pull    
4.3 Kirjoita esim.: git add ".\tiedoston_nimi.php" lisätäksesi kaikki työsi/muutoksesi   
4.4 Kirjoita: git commit -m "kommentoi mitä teit tai muutit"   
4.5 Kirjoita: git pull    
4.6 Kirjoita git push    
