package lp.map;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.HashMap;
import java.util.LinkedHashMap;
import lp.LPApp;
import ontology.EGoal;

/**
 *
 * @author shuaiguo
 */
public class MapInfoDialog extends MMDialog {

    private HashMap<Rectangle, Object> actions = new HashMap<Rectangle, Object>();
    private MapBg parent;
    private Object selected;
    private String title, info, action, change;
    private int ilen, alen;
    private int optionHeight, optionBase;
    private Rectangle ron, rselected;
    private Stroke rstroke = new BasicStroke(2.0f);

    public MapInfoDialog(MapBg parent, String title, String info, String change, String action) {
        super();

        this.title = title;
        this.info = info;
        this.change = change;
        this.action = action;
        this.parent = parent;

        initDialog();
    }

    private void initDialog() {
        Graphics g = LPApp.getApplication().view.mainPanel.getGraphics();

        g.setFont(new Font("微软雅黑", Font.BOLD, 16));
        FontMetrics fm = g.getFontMetrics();
        optionHeight = fm.getHeight();
        optionBase = fm.getAscent();
        ilen = fm.stringWidth(change);
        alen = fm.stringWidth(action);

        bound.setSize(400, (optionHeight + 20) * 5);

        actions.put(new Rectangle((bound.width - ilen) / 2 - 10, (optionHeight + 20) * 3, ilen + 20, 10 + optionHeight), "change");
        actions.put(new Rectangle((bound.width - alen) / 2 - 10, (optionHeight + 20) * 4, alen + 20, 10 + optionHeight), "ok");
    }

    @Override
    public void paint(Graphics2D g, int vw, int vh) {
        if (boundshow) {
            g.setColor(Color.BLACK);
            g.draw(showRect);
        } else {
            bound.setLocation((vw - bound.width) / 2, (vh - bound.height) / 2);
            g.setColor(Color.LIGHT_GRAY);
            g.setFont(new Font("微软雅黑", Font.BOLD, 14));
            g.fill(bound);
            g.setColor(Color.BLACK);
            g.draw(bound);

            int cy = bound.y;
            g.drawString(title, bound.x + 10, cy + 5 + optionBase);
            g.drawLine(bound.x, cy + 10 + optionHeight, bound.x + bound.width, cy + 10 + optionHeight);

            Stroke stroke = g.getStroke();

            g.setStroke(rstroke);
            if (ron != null) {
                g.setColor(Color.YELLOW);
                g.drawRect(ron.x + bound.x, ron.y + bound.y, ron.width, ron.height);
            }

            if (rselected != null) {
                g.setColor(Color.MAGENTA);
                g.drawRect(rselected.x + bound.x, rselected.y + bound.y, rselected.width, rselected.height);
            }

            g.setStroke(stroke);

            g.setColor(Color.BLACK);

            g.setFont(new Font("微软雅黑", Font.PLAIN, 16));
            cy += 30 + optionHeight;
            g.drawString(info, bound.x + 20, cy + 5 + optionBase);

            cy += 10 + optionHeight;

            g.setFont(new Font("微软雅黑", Font.BOLD, 16));
            cy += 20 + optionHeight;
            g.drawString(change, bound.x + (bound.width - ilen) / 2, cy + 5 + optionBase);
            cy += 20 + optionHeight;
            g.drawString(action, bound.x + (bound.width - alen) / 2, cy + 5 + optionBase);
        }
    }

    private void doAction(Object action) {
        if (action instanceof String) {
            if (action.equals("ok")) {
                //todo: 设定选定
                parent.hideMapDialog(null);
            } else if (action.equals("change")) {
                LinkedHashMap lhm = new LinkedHashMap<String, Object>();

                for (EGoal goal : parent.goals) {
                    lhm.put(goal.getName(), goal);
                }
                parent.switchDialog(new MapDialog(parent, "请选择您的学习目标", lhm, "确　定"));
            }
        }
    }

    @Override
    public boolean mouseOn(int x, int y) {
        boolean rtv;
        for (Rectangle rect : actions.keySet()) {
            if (rect.contains(x, y)) {
                if (ron != null && ron.equals(rselected)) {
                    ron = null;
                    return true;
                } else {
                    rtv = !rect.equals(ron);
                    ron = rect;

                    return rtv;
                }

            }
        }

        rtv = ron != null;
        ron = null;

        return rtv;
    }

    @Override
    public boolean mouseClick(int x, int y) {
        for (Rectangle rect : actions.keySet()) {
            if (rect.contains(x, y)) {
                rselected = rect;
                selected = actions.get(rect);
                doAction(selected);
                return true;
            }
        }
        return false;
    }
}
