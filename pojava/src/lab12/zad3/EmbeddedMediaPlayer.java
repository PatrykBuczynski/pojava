package lab12.zad3;
/*
 * Copyright (c) 2012, 2014 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;

import org.jfree.io.FileUtilities;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class EmbeddedMediaPlayer extends Application {

	private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

	MediaPlayer mediaPlayer;
	MediaControl mediaControl;
	Group root;

	public void start(final Stage primaryStage) {

		primaryStage.setTitle("Embedded Media Player");
		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("File");
		menuBar.getMenus().addAll(menuFile);
		root = new Group();
		Scene scene = new Scene(root, 500, 300);
		root.getChildren().addAll(menuBar);
		MenuItem chooseFile = new MenuItem("Choose File");
		menuFile.getItems().addAll(chooseFile);
		chooseFile.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// create media player
				JFileChooser fileChooser = new JFileChooser();
				int returnVal = fileChooser.showOpenDialog(null);
				if(returnVal == fileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					
					Media fileMedia = new Media(selectedFile.toURI().toString());
					mediaPlayer = new MediaPlayer(fileMedia);
					mediaPlayer.setAutoPlay(true);
					mediaControl = new MediaControl(mediaPlayer);
					scene.setRoot(mediaControl);
				}
//				Media media = new Media(MEDIA_URL);
//				mediaPlayer = new MediaPlayer(media);
				
			}
			
		});

		// create media player
//		Media media = new Media(MEDIA_URL);
//		mediaPlayer = new MediaPlayer(media);
//		mediaPlayer.setAutoPlay(true);
//		mediaControl = new MediaControl(mediaPlayer);
//		scene.setRoot(mediaControl);
		
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}