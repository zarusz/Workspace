import { TaskWebPage } from './app.po';

describe('task-web App', () => {
  let page: TaskWebPage;

  beforeEach(() => {
    page = new TaskWebPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
