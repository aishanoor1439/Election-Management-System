 
package com.mycompany.mavenproject26;

 
public class MenuClass {
 
    public void openElections(Menu menu) {
        new Elections().setVisible(true);
        menu.dispose();
    }

    public void openCandidates(Menu menu) {
        new Candidates().setVisible(true);
        menu.dispose();
    }

    public void openVoters(Menu menu) {
        new Voters().setVisible(true);
        menu.dispose();
    }

    public void openDashboard(Menu menu) {
        new Dashboard().setVisible(true);
        menu.dispose();
    }
} 
 
