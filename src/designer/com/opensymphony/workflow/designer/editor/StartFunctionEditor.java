package com.opensymphony.workflow.designer.editor;

import com.opensymphony.workflow.designer.InitialActionCell;
import com.opensymphony.workflow.designer.WorkflowDesigner;
import com.opensymphony.workflow.loader.AbstractDescriptor;
import com.opensymphony.workflow.loader.ConfigFunctionDescriptor;

/**
 * @author jackflit
 * Date: 2003-11-24
 */
public class StartFunctionEditor extends FunctionEditor
{
  public StartFunctionEditor(InitialActionCell cell)
  {
    super(cell);
    // TODO Auto-generated constructor stub
  }

  protected InitialActionCell getCell()
  {
    return (InitialActionCell)cell;
  }

  protected AbstractDescriptor getParent()
  {
    return getCell().getActionDescriptor();
  }

  protected ConfigFunctionDescriptor getNewFunction(String selection)
  {
    return new ConfigFunctionDescriptor(WorkflowDesigner.config.getPrefunction(selection));
  }

  protected String getSelection()
  {
    return DialogUtils.getUserSelection(WorkflowDesigner.config.getPreNames(), "Select Function", "Select Function", null);
  }

}