package ua.training.adapter;

public class AdapterApp {
    public static void main(String[] args) {
        VectorGraphicsInterface vectorGraphicsInterface =
                new VectorAdapterFromRaster2(new RasterGraphics());
        vectorGraphicsInterface.drawLine();
        vectorGraphicsInterface.drawSquare();
    }
}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("draw line");
    }

    void drawRasterSquare() {
        System.out.println("draw square");
    }
}

class VectorAdapterFromRaster extends RasterGraphics
        implements VectorGraphicsInterface{

    public void drawLine() {
        drawRasterLine();
    }

    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{

    private RasterGraphics rasterGraphics;

    public VectorAdapterFromRaster2(RasterGraphics rasterGraphics) {
        this.rasterGraphics = rasterGraphics;
    }

    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}
