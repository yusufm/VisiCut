/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t_oster.jepilog.postscript;

import java.io.IOException;
import java.util.List;

import net.sf.ghost4j.Ghostscript;
import net.sf.ghost4j.GhostscriptException;
import net.sf.ghost4j.display.PageRaster;
import net.sf.ghost4j.display.PageRasterDisplayCallback;
import net.sf.ghost4j.document.Document;
import net.sf.ghost4j.document.DocumentException;
import net.sf.ghost4j.document.PDFDocument;
import net.sf.ghost4j.document.PSDocument;
import net.sf.ghost4j.renderer.AbstractRemoteRenderer;
import net.sf.ghost4j.renderer.RendererException;
import net.sf.ghost4j.util.DiskStore;

public class RasterRenderer extends AbstractRemoteRenderer {
	
	/**
	 * Renderer output resolution in DPI.
	 * Defaults is 75dpi.
	 */
	private int resolution = 75;
	
	public RasterRenderer() {
		
		//set supported classes
        supportedDocumentClasses = new Class[2];
        supportedDocumentClasses[0] = PDFDocument.class;
        supportedDocumentClasses[1] = PSDocument.class;
	}
	
	/**
	 * Main method used to start the renderer in standalone 'slave mode'.
	 * @param args
	 * @throws RendererException
	 */
	public static void main(String[] args) throws RendererException {
		
		startRemoteRenderer(new RasterRenderer());
	}

	@Override
	public List<PageRaster> run(Document document, int begin, int end)
			throws IOException, RendererException, DocumentException {
		
		 //assert document is supported
        this.assertDocumentSupported(document);
        
        //get Ghostscript instance
        Ghostscript gs = Ghostscript.getInstance();
        
        //generate a unique diskstore key for input file
        DiskStore diskStore = DiskStore.getInstance();
        String inputDiskStoreKey = document.toString() + String.valueOf(System.currentTimeMillis() + String.valueOf((int)(Math.random() * (1000-0))));
        
        //write document to input file
        document.write(diskStore.addFile(inputDiskStoreKey));
        
        //create display callback
        PageRasterDisplayCallback displayCallback = new PageRasterDisplayCallback();
        
        int imgwidth = (177*resolution)/72+1;
        int imgheight = (25*resolution)/72+1;
        
        //prepare args
        String[] gsArgs = {
        		"-dQUIET",
        		"-dNOPAUSE",
        		"-dBATCH",
        		"-dSAFER",
        		"-dFirstPage=" + (begin + 1),
        		"-dLastPage=" + (end + 1),
                        "-g"+imgwidth+"x"+imgheight,
        		"-sDEVICE=display",
        		"-dDisplayHandle=0",
        		"-dDisplayFormat=16#804",
        		"-r" + this.getResolution(),
        		"-f",
        		diskStore.getFile(inputDiskStoreKey).getAbsolutePath()};
		
        //execute and exit interpreter
    	try {
	        synchronized(gs){
	    	  
	        	//set display callback
	            gs.setDisplayCallback(displayCallback);
	            
				gs.initialize(gsArgs);
	            gs.exit();
	            
	        }
		} catch (GhostscriptException e) {
			
			throw new RendererException(e);
			
		} finally {
			
			//delete Ghostscript instance
        	try {
				Ghostscript.deleteInstance();
			} catch (GhostscriptException e) {
				throw new RendererException(e);
			}
			
			//remove temporary file
            diskStore.removeFile(inputDiskStoreKey);
		}
		
		return displayCallback.getRasters();
   
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

}
