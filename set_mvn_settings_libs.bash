#bash
_MVN_R=$1
_MVN_W=$1
MASTER_PASSWORD=whatever

_EMP=`mvn -emp $MASTER_PASSWORD`

echo "<settingsSecurity>
  <master>$_EMP</master>
</settingsSecurity>" > settings-security.xml

mv settings-security.xml ~/.m2/

_E_MVN_R=`mvn -ep $_MVN_R`
_E_MVN_W=`mvn -ep $_MVN_W`

echo "<settings> 
	<servers> 
	   <server>
              <id>37coins.myMavenRepo.read</id>
              <username>myMavenRepo</username>
              <password>$_E_MVN_R</password>
   	   </server>
	   <server>
              <id>37coins.myMavenRepo.write</id>
              <username>myMavenRepo</username>
              <password>$_E_MVN_W</password>
   	   </server>
	</servers>
</settings>" > settings.xml

mv settings.xml ~/.m2/

