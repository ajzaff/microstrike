package com.alanjz.microstrike.app.util

import java.awt.Graphics2D
import java.awt.RenderingHints._

object Rendering {
  def setRenderingHints(g2d : Graphics2D) : Unit = {
    g2d.setRenderingHint(KEY_ALPHA_INTERPOLATION, VALUE_ALPHA_INTERPOLATION_QUALITY)
    g2d.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON)
    g2d.setRenderingHint(KEY_COLOR_RENDERING, VALUE_COLOR_RENDER_QUALITY)
    g2d.setRenderingHint(KEY_DITHERING, VALUE_DITHER_ENABLE)
    g2d.setRenderingHint(KEY_FRACTIONALMETRICS, VALUE_FRACTIONALMETRICS_ON)
    g2d.setRenderingHint(KEY_INTERPOLATION, VALUE_INTERPOLATION_BICUBIC)
    g2d.setRenderingHint(KEY_RENDERING, VALUE_RENDER_QUALITY)
    g2d.setRenderingHint(KEY_STROKE_CONTROL, VALUE_STROKE_PURE)
    g2d.setRenderingHint(KEY_TEXT_ANTIALIASING, VALUE_TEXT_ANTIALIAS_ON)
  }
}
